package com.cepardov.spockexample.controller

import com.cepardov.spockexample.dto.UserDto
import com.cepardov.spockexample.service.ExampleService
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class ExampleControllerSpec extends Specification {

    ExampleController controller = new ExampleController()
    ExampleService service

    def setup(){
        service = Stub(ExampleService)
        controller.service = service
    }

    def "Index"() {
        when:
        def res = controller.index()

        then:
        res instanceof ResponseEntity
        res.body == 'work'
    }

    def "save"() {
        given: "Configuramos la prueba"
        String name = 'name'
        service.save(_ as UserDto) >> FakeUserSave(name)

        when: "Cuando ejecutamos el metodo a probar"
        def response = controller.save(FakeUserSave(name))

        then: "Debe responder las siguientes validaciones para pasar prueba"
        response instanceof ResponseEntity
        response.body != null
        response.body instanceof UserDto

    }

    def "update"() {
        given: "Configuramos la prueba"
        String name = 'name'
        service.save(_ as UserDto) >> FakeUserSave(name)

        when: "Cuando ejecutamos el metodo a probar"
        def response = controller.save(FakeUserSave(name))

        then: "Debe responder las siguientes validaciones para pasar prueba"
        response instanceof ResponseEntity
        response.body != null
        response.body instanceof UserDto

    }

    def "delete"() {
        given:
        service.delete(_ as UserDto) >> null

        when:
        def res = controller.delete(FakeUserSave('name'))

        then:
        res instanceof ResponseEntity
    }


    def "FakeUserSave"(String name) {
        UserDto userDto = new UserDto()
        userDto.id = 1L
        userDto.name = name
        userDto.created = new Date()
        return userDto
    }
}
