(defproject macchiato/crypto "0.0.4"
  :description "a library for securely hashing passwords"
  :url "https://github.com/yogthos/macchiato-framework/macchiato-crypto"
  :scm {:name "git"
         :url "https://github.com/macchiato-framework/macchiato-crypto.git"}
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :clojurescript? true
  :dependencies [[org.clojure/clojure "1.9.0" :scope "provided"]
                 [org.clojure/clojurescript "1.10.238" :scope "provided"]]
  :plugins [[codox "0.6.4"]
            [lein-doo "0.1.7"]
            [macchiato/lein-npm "0.6.6"]
            [lein-cljsbuild "1.1.7"]]

  :npm {:name "@macchiato/crypto"
        :write-package-json true
        :private false
        :directories {:lib "src"}
        :files ["src/*"]
        :author {:name "Dmitri Sotnikov"
                 :email "dmitri.sotnikov@gmail.com"
                 :url "http://yo5.0.0.net/"}
        :dependencies [[bcrypt "5.0.0"]
                       [scrypt "6.0.3"]]}
  :profiles {:test
             {:cljsbuild
                   {:builds
                    {:test
                     {:source-paths ["src" "test"]
                      :compiler     {:main          macchiato.test.runner
                                     :output-to     "target/test/core.js"
                                     :target        :nodejs
                                     :optimizations :none
                                     :source-map    true
                                     :pretty-print  true}}}}
              :doo {:build "test"}}}

  :aliases
  {"test"
   ["do"
    ["npm" "install"]
    ["clean"]
    ["with-profile" "test" "doo" "node" "once"]]
   "test-watch"
   ["do"
    ["npm" "install"]
    ["clean"]
    ["with-profile" "test" "doo" "node"]]})
