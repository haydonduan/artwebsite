package com.art.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.score.domain.Score;
import com.art.score.repository.ScoreRepository;
import com.art.user.domain.User;
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

	
	@Autowired
	private ScoreRepository scoreRepository;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateScore(int AddScore,Long userId) {
		User user = new User();
		user.setId(userId);
		Score s =  scoreRepository.findByUserId(user);
		if(s == null){
			Score s1 = new Score();
			s1.setUserId(user);
			s1.setScore(AddScore);
			scoreRepository.save(s1);
		}else{
			int oldScore = s.getScore();
			int newScore = oldScore + AddScore;
			s.setScore(newScore);
			scoreRepository.save(s);
		}
	}
}
