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

SRC_URI += "file://0001-V4L2-Enumerate-available-sensor-controls.patch"
SRC_URI += "file://0002-V4L2-Enumerate-available-media-entities.patch"
SRC_URI += "file://0003-V4L2-Introducing-ERC-BIAS-and-ROI-V4L2-facilities.patch"
SRC_URI += "file://0004-V4L2-Update-the-V4L2-device-builder-to-instantiate-v.patch"
SRC_URI += "file://0005-V4L2-Add-crop-support.patch"
SRC_URI += "file://0006-V4L2-Introducing-V4L2Crop-facility.patch"
SRC_URI += "file://0007-V4L2-add-v4l2-device-geometry-helpers.patch"
SRC_URI += "file://0008-V4L2-ROI-interface-should-not-be-genx320-specific.patch"
SRC_URI += "file://0009-V4L2-Avoid-breaking-imx636-relative-bias-behaviour.patch"
SRC_URI += "file://0010-add-support-for-multiple-media-devices-being-iterate.patch"
SRC_URI += "file://0011-Use-the-selection-API-to-get-the-sensor-Geometry.patch"
SRC_URI += "file://0012-Switch-to-V4L2-MPLANE-API-with-n-1.patch"
SRC_URI += "file://0013-Rely-on-GLEW-for-OpenGLx-stuff.patch"
SRC_URI += "file://0014-Detect-end-of-Evt2.1-buffers.patch"
SRC_URI += "file://0015-Detect-end-of-Evt2.0-buffers.patch"
SRC_URI += "file://0016-Detect-end-of-Evt3.0-buffers.patch"
SRC_URI += "file://0017-Reduce-V4L2-DataTransfer-buffer-pool-to-12.patch"


SRCREV = "8be27a37c6f2de9d1c38d2d7177c6680b35b577a"
