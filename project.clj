(defproject clobber "0.1"
  :description "A ab clone that supports templates"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "0.7.2"]
                 [org.clojure/tools.cli "0.2.2"]]
  :main clobber.cmdline
  :jvm-opts ["-Dfile.encoding=utf-8"])
