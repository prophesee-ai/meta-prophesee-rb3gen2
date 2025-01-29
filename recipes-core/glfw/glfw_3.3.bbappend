DEPENDS:remove = "libglu libxrandr libxinerama libxi libxcursor"

REQUIRED_DISTRO_FEATURES:remove = "x11"
ANY_OF_DISTRO_FEATURES = "wayland x11"

PACKAGECONFIG ??= "wayland"

PACKAGECONFIG[wayland] = "-DGLFW_USE_WAYLAND=ON,,wayland wayland-native wayland-protocols extra-cmake-modules libxkbcommon"
PACKAGECONFIG[x11] = ",,libglu libxrandr libxinerama libxi libxcursor"
