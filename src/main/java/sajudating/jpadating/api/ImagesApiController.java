package sajudating.jpadating.api;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sajudating.jpadating.apiDto.common.CommonApiResponse;
import sajudating.jpadating.apiDto.common.ResponseMessage;
import sajudating.jpadating.apiDto.common.StatusCode;
import sajudating.jpadating.service.ImagesService;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/images")
@Transactional
public class ImagesApiController {
    private final ImagesService imagesService;



    @GetMapping("/{fileName}")
    public ResponseEntity readImages(
            @PathVariable("fileName") String fileName,
            HttpServletRequest request) {
        Resource resource = imagesService.fileToResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {

        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


}
