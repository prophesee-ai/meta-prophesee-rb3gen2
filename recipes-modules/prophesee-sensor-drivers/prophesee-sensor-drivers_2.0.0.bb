SUMMARY = "Recipe to build Prophesee sensor drivers Linux kernel module"
SECTION = "PETALINUX/modules"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a75371ba4d16749254a51215d13f97"

inherit module

SRC_URI = "git://github.com/prophesee-ai/linux-sensor-drivers;protocol=https;branch=kernel-6.6"
SRCREV = "83e5394e5a7d8752f977bf61fa021c27ced905e1"

SRC_URI += "file://0001-Disable-packet-timeout.patch"
SRC_URI += "file://0002-reduce-packet-size-to-less-than-8191.patch"

S = "${WORKDIR}/git"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
