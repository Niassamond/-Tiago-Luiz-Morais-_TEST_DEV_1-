package backend

class UrlMappings {
    static mappings = {
        get "/company"(controller:"company", action:"index");
    }
}