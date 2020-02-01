/**
 * A small groovy script for fast QR codes generation. Will take
 * some time on first execution due to grabbing dependencies.
 * Usage:
 * {code}
 * groovy qr_code_generator.groovy https://www.google.com
 * {code}
 */
@GrabResolver(name='jitpack.io', root='https://jitpack.io/')
@Grab(group = "com.github.kenglxn.QRGen", module = "javase", version = "2.6.0")
import static net.glxn.qrgen.core.image.ImageType.PNG
import static net.glxn.qrgen.javase.QRCode.from

args.each { textToEncode ->
    from(textToEncode).to(PNG).file().with {
        new FileTreeBuilder().file(name).bytes = bytes
        println "QR code has been generated, check out ${name}"
        // Ubuntu: uncomment to open generated code(s) in default program for viewing PNG files:
        // "xdg-open ${name}".execute()
    }
}
