SUMMARY = "Basic Wayland image with V4L2 stuff"

LICENSE = "BSD-3-Clause-Clear"

IMAGE_FEATURES += "splash tools-debug allow-root-login post-install-logging enable-adbd read-only-rootfs package-management ssh-server-openssh"

inherit core-image features_check extrausers image-adbd image-qcom-deploy

REQUIRED_DISTRO_FEATURES = "pam systemd wayland"

CORE_IMAGE_BASE_INSTALL += " \
    qcom-resize-partitions \
    packagegroup-filesystem-utils \
    packagegroup-qcom \
    packagegroup-qcom-multimedia \
    libcamera \
    v4l-utils \
    yavta \
    i2c-tools \
    libgpiod \
    libgpiod-tools \
    prophesee-sensor-drivers \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    libgomp \
    libgomp-dev \
    libgomp-staticdev \
    overlayfs-qcom-paths \
"

EXTRA_USERS_PARAMS = "\
    useradd -r -s /bin/false system; \
    usermod -p '\$6\$UDMimfYF\$akpHo9mLD4z0vQyKzYxYbsdYxnpUD7B7rHskq1E3zXK8ygxzq719wMxI78i0TIIE0NB1jUToeeFzWXVpBBjR8.' root; \
    "

# Adding kernel-devsrc to provide kernel development support on SDK
TOOLCHAIN_TARGET_TASK += "kernel-devsrc"

# docker pulls runc/containerd, which in turn recommend lxc unecessarily

BAD_RECOMMENDATIONS:append = " lxc"
