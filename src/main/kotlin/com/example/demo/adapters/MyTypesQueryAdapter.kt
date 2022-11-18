package com.example.demo.adapters

import com.asml.ais.avp.timelineuiapi.graphql.model.*
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class MyTypesQueryAdapter : MyTypesQueryResolver, MyTypeResolver {

    @QueryMapping
    override fun myTypes(): List<GqlMyType> {
       return listOf(GqlMyType("ID","FIELD", GqlSubTypeB("SUB B", "needs override"), null))
    }

    @SchemaMapping
    override fun subTypeA(myType: GqlMyType): GqlSubTypeA {
        return GqlSubTypeA("SUB ID", "sub field ${myType.field}")
    }

    @SchemaMapping
    fun subTypeB(myType: GqlMyType): GqlSubTypeB {
        return GqlSubTypeB("SUB ID", "sub field ${myType.field}")
    }

    @SchemaMapping
     fun subTypeC(myType: GqlMyType): GqlSubTypeC {
        return GqlSubTypeC("SUB ID", "sub field ${myType.field}")
    }

}