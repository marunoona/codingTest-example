package question08;

import java.util.*;

public class Matching {
    class Page{
        Page(int idx, int basic, int link, double score){
            this.idx = idx;
            this.basic = basic;
            this.link = link;
            this.score = score;
        }
        int idx;
        int basic, link;
        double score;
    }

    class Comp implements Comparator<Page> {
        public int compare(Page a, Page b){
            if(a.score == b.score)
                return a.idx - b.idx;
            else if(a.score < b.score)
                return 1;
            else
                return -1;
        }
    }

    public int solution(String word, String[] pages) {
        int wsize = word.length();
        Map<String, Integer> pageMap = new HashMap<>();
        List<Page> pageList = new ArrayList<>();
        word = word.toLowerCase();
        for(int i = 0; i < pages.length; i ++){
            String s = pages[i] = pages[i].toLowerCase();
            int mid = 0, posl = 0, posr = 0;
            //<meta ~ >에서 url 추출 과정
            while(mid <= posl){
                posl = s.indexOf("<meta", posl + 1);
                posr = s.indexOf(">", posl);
                mid = s.lastIndexOf("https://", posr);
            }
            posr = s.indexOf("\"", mid);
            String url = s.substring(mid, posr);

            posl = s.indexOf("<body>", posr);
            //기본 점수 찾는 과정
            int basic = 0;
            for(int start = posr; ;){
                start = s.indexOf(word, start + 1);
                if(start == -1) break;
                if(!Character.isLetter(s.charAt(start-1)) &&
                        !Character.isLetter(s.charAt(start + wsize))){
                    basic++;
                    start += wsize;
                }
            }
            //외부 링크 수 찾는 과정
            int link = 0;
            for(int start = posl; ;){
                start = s.indexOf("<a href", start + 1);
                if(start == -1) break;
                link++;
            }
            //url과 index값 정보를 저장
            pageMap.put(url, i);
            pageList.add(new Page(i, basic, link, (double)basic));
        }

        for(int i = 0; i < pages.length; ++i){
            String s = pages[i];
            for(int posl = 0, posr = 0 ; ;){
                posl = s.indexOf("<a href", posr);
                if(posl == -1) break;

                posl = s.indexOf("https://", posl);
                posr = s.indexOf("\"", posl);
                String linkurl = s.substring(posl, posr);

                Integer value = pageMap.get(linkurl);
                if(value != null){
                    pageList.get(value).score += (double)pageList.get(i).basic / pageList.get(i).link;
                }
            }
        }
        //조건대로 정렬
        pageList.sort(new Comp());
        return pageList.get(0).idx;
    }
}
