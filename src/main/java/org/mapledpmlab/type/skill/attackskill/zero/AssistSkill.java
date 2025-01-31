package org.mapledpmlab.type.skill.attackskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;

@Setter
@Getter
public class AssistSkill extends AttackSkill {
    private Long assistDelay = 0L;
    private AssistSkill assistSkill = null;
    private boolean isMove = false;

    @Override
    public String getInfo() {
        String str = super.getInfo();
        str = str + "\n어시스트 딜레이 : " + getAssistDelay();
        this.setColNum(this.getColNum() + 1);
        if (getAssistSkill() != null) {
            str = str + "\n어시스트 스킬 : " + getAssistSkill().getName();
            this.setColNum(this.getColNum() + 1);
        }
        if (isMove()) {
            str = str + "\n이동기 연결 제약 적용";
            this.setColNum(this.getColNum() + 1);
        }
        return str;
    }
}
