package fr.tncy.crown.controller;

import fr.tncy.crown.model.Ranking;
import fr.tncy.crown.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RankingController {

  private RankingService rankingService;

  @Autowired
  public RankingController(RankingService rankingService){
    this.rankingService = rankingService;
  }

  @RequestMapping(value = "/rank/new", method = RequestMethod.GET)
  @ResponseBody
  public void newRank(
    @RequestParam(value = "userId")String userId,
    @RequestParam(value = "wordsListId")String wordsListId,
    @RequestParam(value = "score")String score) {
    rankingService.addOne(Integer.parseInt(userId), Integer.parseInt(wordsListId), Integer.parseInt(score));
  }

  @RequestMapping(value = "/rank/by-words", method = RequestMethod.GET)
  @ResponseBody
  public List<Ranking> newRank(
    @RequestParam(value = "wordsListId")String wordsListId) {
    return rankingService.byWordsList(Integer.parseInt(wordsListId));
  }


}
