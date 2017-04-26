package page;

import java.util.ArrayList;
import java.util.List;

import pojo.Goods;

public class PageView {
	private ArrayList<Goods> records;// ��¼
    private Long totalrecordnumber;// �ܼ�¼��
    private Integer startindex;// ��һҳ
    private Integer endindex;// ���һҳ
    private Integer totalpagenumber;// ��ҳ��
    private Integer currentpage;// ��ǰҳ
    public PageView(ArrayList<Goods> records, Long totalrecordnumber, int currentpage,
      int maximum, int viewperpage)
    // ���캯��
    {
     this.records = records;
     this.totalrecordnumber = totalrecordnumber;
     this.currentpage = currentpage;
     totalpagenumber = (int) (totalrecordnumber % maximum == 0 ? totalrecordnumber
       / maximum
       : totalrecordnumber / maximum + 1);//�����ҳ��
     setIndex(currentpage, viewperpage, totalpagenumber);
    }
    public ArrayList<Goods> getRecords() {
     return records;
    }
    public Long getTotalrecordnumber() {
     return totalrecordnumber;
    }
    public Integer getStartindex() {
     return startindex;
    }
    public Integer getEndindex() {
     return endindex;
    }
    public Integer getTotalpagenumber() {
     return totalpagenumber;
    }
    public Integer getCurrentpage() {
     return currentpage;
    }
   //�����ҳ�� ��ʾҳ�� ��ǰҳ�� ��һҳ ���һҳ
    public void setIndex(int currentpage, int viewperpage, int totalpagenumber) {
     if (viewperpage >= totalpagenumber) {
      startindex = 1;
      endindex = totalpagenumber;
     } else {
      if (currentpage <= viewperpage / 2) {
       startindex = 1;
       endindex = viewperpage;
      } else if ((currentpage + viewperpage / 2) > totalpagenumber) {
       startindex = totalpagenumber - viewperpage + 1;
       endindex = totalpagenumber;
      } else {
       startindex = currentpage - (viewperpage - 1) / 2;
       endindex = currentpage + viewperpage / 2;
      }
     }
    }
}
