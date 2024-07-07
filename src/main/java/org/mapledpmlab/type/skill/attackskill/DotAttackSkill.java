package org.mapledpmlab.type.skill.attackskill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DotAttackSkill extends AttackSkill {
    public String getInfo() {
        String str;
        str = super.getInfo();
        str = str + "\n도트 스킬";
        setColNum(getColNum() + 1);
        return str;
    }
}
