SUMMARY = "Test::Warnings - Test for warnings and the lack of them"
DESCRIPTION = "If you've ever tried to use Test::NoWarnings to confirm there are no \
warnings generated by your tests, combined with the convenience of \
\\"done_testing\\" to not have to declare a test count, you'll have discovered \
that these two features do not play well together, as the test count will \
be calculated *before* the warnings test is run, resulting in a TAP error. \
(See "examples/test_nowarnings.pl" in this distribution for a \
demonstration.)"
HOMEPAGE = "https://github.com/karenetheridge/Test-Warnings"
BUGTRACKER = "https://rt.cpan.org/Public/Dist/Display.html?Name=Test-Warnings"
SECTION = "libs"
LICENSE = "Artistic-1.0-Perl | GPL-1.0-or-later"

LIC_FILES_CHKSUM = "file://LICENCE;md5=f98106ac3cc05d9cbebcdb8fbf7b7815"

SRC_URI = "${CPAN_MIRROR}/authors/id/E/ET/ETHER/Test-Warnings-${PV}.tar.gz"

SRC_URI[sha256sum] = "3da27e003a3c3cafed3c09b42be05cf9bdbff0bee5c8590a731b02853880a273"

S = "${WORKDIR}/Test-Warnings-${PV}"

inherit cpan ptest-perl

RDEPENDS:${PN} += "\
    perl-module-test-builder \
"

# Many hidden dependencies and mysterious failures occur without full perl-modules
RDEPENDS:${PN}-ptest += "perl-modules"

do_install_ptest_perl:append () {
    cp -r ${B}/t/lib ${D}${PTEST_PATH}/t/
    chown -R root:root ${D}${PTEST_PATH}/t/lib
}

BBCLASSEXTEND = "native nativesdk"
