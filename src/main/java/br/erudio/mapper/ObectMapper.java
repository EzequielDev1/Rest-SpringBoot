package br.erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObejct(O origin, Class<D> destination ){
      return   mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObejct(List<O> origin, Class<D> destination) {
        List<D> Destination = new ArrayList<>();

        for (O o : origin) {
            DO.add(mapper.map(o, destination));
        }

        return DO;
    }
}
