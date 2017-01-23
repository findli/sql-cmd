new java.io.File('.').eachFile{
    println it
}

println()

def pw = new java.io.File('textFile.txt').newPrintWriter()
pw.println("line start!")
for (int i = 0; i < 5; i++) {
    pw.println("line ${i}")
}
pw.close()

new java.io.File('textFile.txt').eachLine{
    println(it)
}