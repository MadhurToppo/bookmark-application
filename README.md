# bookmark-application

## Running the Application

```shell
$ git clone https://github.com/MadhurToppo/bookmark-application.git
$ cd bookmark-application
$ ./run.sh start
$ ./run.sh stop

$ ./run.sh start_infra
$ ./run.sh stop_infra
```

* To start only dependent services

```shell
$ ./run.sh start_infra
$ ./run.sh stop_infra
```

## Running on Kubernetes

```shell
$ cd springboot-kubernetes-youtube-series
$ cd kind
$ ./create-cluster.sh
$ cd ../k8s/
$ kubectl apply -f .
```
- To delete deployments and cluster
```shell
$ kubectl delete -f .
$ cd ../kind/
$ ./destroy-cluster.sh
```

* API endpoint with NodePort http://localhost:18080/api/bookmarks
* UI endpoint with NodePort http://localhost:30080/
* API endpoint with Ingress http://localhost/bookmarker-api/api/bookmarks
* UI endpoint with Ingress http://localhost/

Project inspired from https://www.youtube.com/playlist?list=PLuNxlOYbv61h66_QlcjCEkVAj6RdeplJJ