# scala-groovy-templates

Sample project showing how to render HTML in Scala using Groovy's
[MarkupTemplateEngine](http://docs.groovy-lang.org/latest/html/documentation/template-engines.html#_the_markuptemplateengine).

I considered [Groovy Server Pages](http://grails.github.io/grails-doc/2.2.5/guide/theWebLayer.html) but they seemed quite heavyweight.
I've used PHP but it requires a separate daemon and is not in-JVM.
I've considered JRuby but Groovy has lovely JSON support.

There even is work on [integrating Scala into Ruby](http://www.codecommit.com/blog/ruby/integrating-scala-into-jruby)
and [scuby](https://github.com/mcamou/scuby) but it won't be moving forward much by the look of it.

Also considered [Apache FreeMaker](http://freemarker.incubator.apache.org) but Groovy is more full fledged.

Twirl is nice and strong typed but the refresh cycles are just too slow - and your whole app needs to be restarted
every single time. Which is a no-go.

Key advantage is that the template is interpreted rather than compiled unlike Twirl.

Here the easiest way is to take a Scala value and turn it into a Java object (e.g. pure maps/etc),
which is then accessed natively by Groovy.

That conversion can be whatever you like.

In this particular demo we're converting [to JSON via play-json](https://www.playframework.com/documentation/2.4.x/ScalaJson)
and then using [groovy's JSON parser](http://www.groovy-lang.org/json.html) to turn it into a Java object.

Yes it is not efficient but we never optimise prematurely.

![Knuth](http://41.media.tumblr.com/6dc8a9cf3bac60b4033762ffa8c28438/tumblr_mqointtMJv1sd1dvqo1_500.jpg)
