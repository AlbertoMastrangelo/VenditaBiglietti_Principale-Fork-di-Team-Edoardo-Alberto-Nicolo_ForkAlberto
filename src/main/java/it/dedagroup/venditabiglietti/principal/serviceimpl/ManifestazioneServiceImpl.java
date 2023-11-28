package it.dedagroup.venditabiglietti.principal.serviceimpl;

import it.dedagroup.venditabiglietti.principal.dto.request.AddManifestazioneDTORequest;
import it.dedagroup.venditabiglietti.principal.dto.response.ManifestazioneMicroDTO;
import org.springframework.stereotype.Service;

import it.dedagroup.venditabiglietti.principal.service.GeneralCallService;
import it.dedagroup.venditabiglietti.principal.service.ManifestazioneServiceDef;

@Service
public class ManifestazioneServiceImpl implements ManifestazioneServiceDef, GeneralCallService{

	String pathManifestazione="http://localhost:8084/";
	
	@Override
	public void eliminaManifestazione(long id) {
		callPost(pathManifestazione+"manifestazione/delete/"+id, id, String.class);
		
	}

	@Override
	public ManifestazioneMicroDTO findById(long idManifestazione) {
		String mioPath=pathManifestazione+"manifestazione/find-id/"+idManifestazione;
		return callGet(mioPath,idManifestazione,ManifestazioneMicroDTO.class);
	}

	@Override
	public ManifestazioneMicroDTO findByNome(String nome) {
		String path = pathManifestazione+"manifestazione/find/"+nome;
		return callGet(path, nome, ManifestazioneMicroDTO.class);
	}

	@Override
	public ManifestazioneMicroDTO save(AddManifestazioneDTORequest request) {
		String path = pathManifestazione+"manifestazione/new/"+request.getNome();
		return callPost(path, request.getNome(),ManifestazioneMicroDTO.class);
	}


}
