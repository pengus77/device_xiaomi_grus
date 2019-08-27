# apply patches
workdir=$(pwd)
cd hardware/qcom/audio-caf/sdm845 || return
git reset -q --hard
[ "$target" == "grus" ] && patch --merge -sNp1 -i "$workdir"/device/xiaomi/grus/patches/libtinycompress.patch
cd "$workdir" || return

# end patches


add_lunch_combo lineage_grus-userdebug

