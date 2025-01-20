package topicos.api.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import topicos.api.domain.ValidacionException;

@Component
public class ValidadorTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(Topico topico){
        boolean existe = topicoRepository.existsByTituloAndMensaje(topico.getTitulo(), topico.getMensaje());

        if (existe) {
            throw new ValidacionException("No se puede agregar un topico con el mismo titulo y mensaje que otro topico ya existente");
        }
    }

    public void validar(String titulo, String mensaje){
        boolean existe = topicoRepository.existsByTituloAndMensaje(titulo, mensaje);

        if (existe) {
            throw new ValidacionException("No se puede actualizar un topico con el mismo titulo y mensaje que otro topico ya existente");
        }
    }

}
