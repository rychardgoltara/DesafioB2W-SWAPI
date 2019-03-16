-Aplicação utiliza spring boot. Será necessário iniciá-la através do mesmo.
-Para iniciar crie uma Base com o nome "planetsproject" e uma coleção com o nome 'planet' dentro da mesma.

Funcionalidades: 
Recuperar todos os planetas: HTTP GET
http://localhost:8080/planets

Recuperar Um planeta específico : HTTP GET
http://localhost:8080/planets/{id}

Recuperar um planeta por nome : HTTP GET 
http://localhost:8080/planets/name/{name}

Inserir um Planeta : HTTP POST
http://localhost:8080/planets

Recuperar um planeta para UPDATE : HTTP PUT
http://localhost:8080/planets/{id}

Deletar um planeta : HTTP DELETE
http://localhost:8080/planets/{id}
