package io.spring.guides.gs_producing_web_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private PersonRepository personRepository;

    @Autowired
    public PersonEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonByIdRequest")
    @ResponsePayload
    public GetPersonByIdResponce responce(@RequestPayload GetPersonByIdRequest request){
        GetPersonByIdResponce resp = new GetPersonByIdResponce();
        resp.setPerson(personRepository.getPersonById(request.getId()));
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonByNameRequest")
    @ResponsePayload
    public GetPersonByNameResponce responce(@RequestPayload GetPersonByNameRequest request){
        GetPersonByNameResponce resp = new GetPersonByNameResponce();
        resp.setPerson(personRepository.getPersonByName(request.getPersonName()));
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonsByYearRequest")
    @ResponsePayload
    public GetPersonsByYearResponce responce(@RequestPayload GetPersonsByYearRequest request){
        GetPersonsByYearResponce resp = new GetPersonsByYearResponce();
        resp.setPerson(personRepository.getPersonsByYear(request.getYear()));
        return resp;
    }
}
