SUMMARY = "Prophesee Metavision"
DESCRIPTION = "Metavision SDK is an all-in-one package that provides you with a range of \
essential tools, from a visualization application to a comprehensive API."
HOMEPAGE = "https://www.prophesee.ai/metavision-intelligence"

SECTION = "multimedia"

# This recipe builds OpenEB, the part of Metavision that is distributed under Apache-2.0
# It is still called Metavision because OpenEB build produces extra packages such as
# metavision-hal-samples, and it was simpler that way to avoid installed-vs-shipped QA issues
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://licensing/LICENSE_OPEN;md5=c37080f4c2fe1ff35aee0ddacb4466b3"

S = "${WORKDIR}/git"

# Dependencies
DEPENDS = "boost libusb opencv glew glfw libeigen protobuf protobuf-native sophus python3-pybind11 ceres-solver"

# For non-investigated reasons, depending on opencv install only some of the libs built by opencv
# However, the other libs (such as libopencv_calib3d) are a dependency of the opencv package, and
# adding it also as a runtime dependency forces the libopencv_stuff to go in the image
RDEPENDS:${PN}= "opencv"

inherit pkgconfig cmake

EXTRA_OECMAKE = "-DCOMPILE_METAVISION_STUDIO=OFF \
                 -DUSE_OPENGL_ES3=ON \
                 -DOPENGL_USE_EGL=ON \
                 -DCOMPILE_PLAYER=OFF \
                 -DUSE_PROTOBUF=ON \
                 -DUSE_SOPHUS=ON \
                 -DCOMPILE_PYTHON3_BINDINGS=OFF \
                 -DHDF5_DISABLED=ON \
                 -DBUILD_TESTING=OFF"

SRC_URI = "git://git@github.com/prophesee-ai/openeb.git;protocol=https;nobranch=1"

SRC_URI += "file://0001-Upgrade-Prophesee-plugin-to-develop-4f83de8d.patch"
SRC_URI += "file://0002-Rely-on-GLEW-for-OpenGLx-stuff.patch"
SRC_URI += "file://0003-Reduce-V4L2-DataTransfer-buffer-pool-to-12.patch"
SRC_URI += "file://0004-Detect-end-of-Evt2.0-buffers.patch"
SRC_URI += "file://0005-Detect-end-of-Evt2.1-buffers.patch"
SRC_URI += "file://0006-Detect-end-of-Evt3.0-buffers.patch"

SRCREV = "0499c95d921755ab2085125a29750ef365e6e8ae"
