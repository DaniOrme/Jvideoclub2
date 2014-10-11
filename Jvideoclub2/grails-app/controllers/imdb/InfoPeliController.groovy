package imdb

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

class InfoPeliController {
	

    def index() { 
		
		def urlPoster=params.title;
		
		
		BufferedImage image= ImageIO.read(new URL(urlPoster));
			
		response.contentType = 'image/jpeg' //'image/jpeg' will do too
		ImageIO.write(image,'jpg',response.outputStream)
		response.outputStream.flush()
	
		}
}
