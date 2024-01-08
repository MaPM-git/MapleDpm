package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.mercedes.UnfadingGlorySpiritKing;

public class UnfadingGloryDelay extends AttackSkill {
    public UnfadingGloryDelay() {
        this.setName("언페이딩 글로리");
        this.setDelay(5580L);
        this.setRelatedSkill(new UnfadingGlorySpiritKing());
    }
}
