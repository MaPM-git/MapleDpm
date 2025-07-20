package org.mapledpmlab.type.skill.attackskill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DotAttackSkill extends AttackSkill {
    @JsonIgnore
    public String getInfo() {
        String str;
        str = super.getInfo();
        str = str + "\n도트 스킬";
        setColNum(getColNum() + 1);
        return str;
    }
}
