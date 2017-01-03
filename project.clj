(defproject macchiato/crypto "0.0.2"
  :description "a library for securely hashing passwords"
  :url "https://github.com/yogthos/macchiato-framework/macchiato-crypto"
  :scm {:name "git"
         :url "https://github.com/macchiato-framework/macchiato-crypto.git"}
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :clojurescript? true
  :dependencies []
  :plugins [[codox "0.6.4"]
            [lein-npm "0.6.2"]]
  :npm {:dependencies [[bcrypt "1.0.2"]
                       [scrypt "6.0.3"]]}
  :profiles {:dev
             {:dependencies [[org.clojure/clojurescript "1.9.293"]]
              :plugins [[lein-cljsbuild "1.1.4"]]}})
