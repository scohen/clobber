# Clobber

A Clojure stress testing tool inspired by [Apache Bench](http://httpd.apache.org/docs/2.2/programs/ab.html).

## Wait, what?
Yeah, I know. Why on earth would you re-write the venerable Apache Bench in Clojure? Well, two reasons, actually. First, I wanted a simple and fun project to do while learning Clojure, and second, I was doing a bunch of load testing at [Pinterest](http://www.pinterest.com) and needed to quickly produce templatized URLs. Apache Bench is good for slamming a single URL, but we needed to hit thousands of URLs that had very similar traits. Enter Clobber.

Clobber sits in a space where Apache Bench is too little and JMeter is too much.
 
## Using Clobber

Clobber is a command line app with a configuration file, its usage is straightforward. First you need to create a template file so clobber can create many urls. Let's pretend that we have a simple URL scheme like this:

	http://foo.com/users/1/
	http://foo.com/users/2/
	http://foo.com/users/3/things/
	http://foo.com/users/3/other_things/

We want to stress test all of these URLs, and Clobber lets us do it easily. Just create a config file with the following syntax:

	{
	:url "http://foo.com/users/:user_id/:path"
  	:templates { :user_id ["1" "2" "3" "4" "5"],
                 :path ["" "things/" "other_things/"]
               }
  	 } 

…and save it to a file called config.clj (the filename doesn't matter)

	`java -jar clojure.jar -c config.clj -n 30`

That will run Clobber using your config file for 30 requests. Clobber will randomly generate urls from your config file and hit your server with each url. Easy. It'll print out a summary when it's done. While it's running, for each request it will put out a + if it was in the 200 range and a - if it wasn't.

The summary looks like this:

	Total time:  		1s
	Average time:  		56ms
	Successes:  		20
	Redirects:  		0
	Errors:  			0

	Percentages:
		50%	  49 ms
		60%	  51 ms
		70%	  52 ms
		80%	  53 ms
		90%	  77 ms
		95%	  94 ms
		99%	  94 ms
		100% 109 ms

## Building
Clobber depends on [Leiningen](https://github.com/technomancy/leiningen), a really incredible Clojure building and dependency management system. Building Clobber with Leiningen is simple, just run `lein uberjar`. This will create a file in the target directory called clobber-<version>-standalone.jar, this is the executable jar file and is all you need to run clobber. 
Rename this to clobber.jar and you're off to the races.


## Contributing
Fork the repo and submit a pull request. You know the drill.


## License

Copyright © 2013 Steve Cohen

Distributed under the Eclipse Public License, the same as Clojure.
