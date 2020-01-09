package com.iu.b1.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;


@Service
//@Qualifier("") 는 AutoWired랑 매칭시킹때 사용하는 것  //같은 이름일 때 이름을 지정해서 사용하는 것
@Transactional
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;

//---------------------------------------------------------------------------		
	public List<NoticeVO> noticeList()throws Exception{
			
		return noticeRepository.findByNumGreaterThanOrderByNumDesc(0);	
	}
	//---------------------------------------------------------------------------	
	public NoticeVO noticeSelect(int num)throws Exception{
		
		return noticeRepository.findById(num).get();
	}
	//---------------------------------------------------------------------------	
	public NoticeVO noticeDelete(NoticeVO noticeVO) throws Exception{
		noticeRepository.deleteById(noticeVO.getNum());
		return noticeRepository.findById(noticeVO.getNum()).get();
		
	}
	//---------------------------------------------------------------------------		
	public void boardWrite(NoticeVO noticeVO, List<MultipartFile> files)throws Exception{
		List<NoticeFIlesVO> noticeFilesVOs = null;
		//---- 파일의 유무 검증
			boolean check = false;
			
			//for 끝
			if(files.size()>0) {
				noticeFilesVOs = new ArrayList<NoticeFIlesVO>();
				for(MultipartFile multipartFile:files) {
					if(multipartFile.getSize() > 0) {
						check = true;
						break;
					}
				}
				
				if(check) {
					NoticeFIlesVO noticeFilesVO = new NoticeFIlesVO();
					for(MultipartFile multipartFile:files) {
						if(multipartFile.getSize() > 0) {
							File file = filePathGenerator.getUseClassPathResource("upload");
							String fileName = fileSaver.save(file, multipartFile);
							noticeFilesVO.setFname(fileName);
							noticeFilesVO.setOname(multipartFile.getOriginalFilename());
							noticeFilesVOs.add(noticeFilesVO);
							noticeFilesVO.setNoticeVO(noticeVO);
						}
					}			
							noticeVO.setNoticeFIlesVOs(noticeFilesVOs);
				}
			}	
				//---- 파일 유무 검증
				noticeRepository.save(noticeVO);	
		}		
	//---------------------------------------------------------------------------	
		
		
		
	//---------------------------------------------------------------------------	
		
	//---------------------------------------------------------------------------	
		
		
		
	//---------------------------------------------------------------------------
		
		
		

	
}
