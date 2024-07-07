package org.mapledpmlab.type.skill.attackskill.wildhunter;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;

@Setter
@Getter
public class JaguarSkill extends AttackSkill {
    private Long jaguarDelay = 0L;

    @Override
    public String getInfo() {
        String str = super.getInfo();
        str = str + "\n재규어 딜레이 : " + getJaguarDelay();
        this.setColNum(this.getColNum() + 1);
        return str;
    }
}
