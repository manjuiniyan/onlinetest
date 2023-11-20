public class Exam {
    String exam_id;

    String topc_id;
    String exam_name;
    String exam_duration;
    String start_time;
    String end_time;
    public String getExam_id() {
        return exam_id;
    }

    public String getTopc_id() {
        return topc_id;
    }

    public String getExam_name() {
        return exam_name;
    }

    public String getExam_duration() {
        return exam_duration;
    }

    public String getStart_time() {
        return start_time;
    }
    public String getEnd_time(){
        return end_time; 
    }
    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    public void setTopc_id(String topc_id) {
        this.topc_id = topc_id;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public void setExam_duration(String exam_duration) {
        this.exam_duration = exam_duration;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
   public void setEnd_time(String end_time){
    this.end_time = end_time;
   }
}
