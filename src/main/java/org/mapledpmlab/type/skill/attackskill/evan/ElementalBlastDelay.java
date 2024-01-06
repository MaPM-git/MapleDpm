package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.evan.ElementalBlastBuff;

public class ElementalBlastDelay extends AttackSkill {
    public ElementalBlastDelay() {
        this.setName("엘리멘탈 블래스트");
        this.setDelay(780L);
        this.setRelatedSkill(new ElementalBlastBuff());
    }
}
