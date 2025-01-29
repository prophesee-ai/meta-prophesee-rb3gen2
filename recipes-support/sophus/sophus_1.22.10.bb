DESCRIPTION = "C++ implementation of Lie Groups using Eigen."
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f78120fdd8782ba44f0f9cd9a4a393b"

DEPENDS = "libeigen"

SRC_URI = "git://github.com/strasdat/Sophus.git;protocol=https;nobranch=1"
SRCREV = "de0f8d3d92bf776271e16de56d1803940ebccab9"

S = "${WORKDIR}/git"

inherit cmake

# CXXFLAGS are needed to ignore issues in eigen
CXXFLAGS += "-Wno-error=maybe-uninitialized"
