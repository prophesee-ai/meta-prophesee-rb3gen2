FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://advanced-video-debug.cfg"
SRC_URI += "file://dynamic-debug.cfg"
SRC_URI += "file://declare-Prophesee-V4L2-media-bus-types.patch"
SRC_URI += "file://0002-media-qcom-camss-Disable-frame-measurement.patch"
SRC_URI += "file://0094-imx636-in-dts.patch"
SRC_URI += "file://0001-Fix-types-in-coresight-hwtracing-logs.patch"
SRC_URI += "file://0006-Let-Prophesee-event-formats-pass-through-CAMSS.patch"

