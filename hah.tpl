p('test template')
oopsie.each { o ->
if ( o.b != null ) {
    h1(o.b)
}
    p(o.a, o.b)
br()
}