package br.erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObectMapper {

    // Ele vai mapear o objecto Person -> DTO,e e vice versa.

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObejct(O origin, Class<D> destination){
        return mapper.map(origin, destination);

    }


    public static <O, D> List<D> parseListObejct(List<O> origin, Class<D> destination){

        List<D> destinationObject = new ArrayList<>();

        for(Object o : origin){
            destinationObject.add( mapper.map(origin, destination));
        }
        return destinationObject;

    }

}
