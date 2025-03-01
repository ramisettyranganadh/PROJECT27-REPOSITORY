SUMMARY = "Hardware identification and configuration data"
DESCRIPTION = "hwdata contains various hardware identification and \
configuration data, such as the pci.ids and usb.ids databases."
HOMEPAGE = "https://github.com/vcrhonek/hwdata"
SECTION = "System/Base"

LICENSE = "GPL-2.0-or-later | X11"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1556547711e8246992b999edd9445a57"

SRC_URI = "git://github.com/vcrhonek/${BPN}.git;branch=master;protocol=https"
SRCREV = "e3aac7f6bed87ca6d701bb5ad30f29a8df857f66"

S = "${WORKDIR}/git"

inherit allarch

do_configure() {
    ${S}/configure --datadir=${datadir} --libdir=${libdir}
}

do_compile[noexec] = "1"

do_install() {
    oe_runmake install DESTDIR=${D}
}

FILES:${PN} = "${libdir}/* \
               ${datadir}/* "

BBCLASSEXTEND += "native"
