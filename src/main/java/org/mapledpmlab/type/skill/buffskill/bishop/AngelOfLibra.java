package org.mapledpmlab.type.skill.buffskill.bishop;

import org.mapledpmlab.type.skill.attackskill.bishop.AngelOfLibraRevenge;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

public class AngelOfLibra extends BuffSkill {
    public AngelOfLibra() {
        this.setName("엔젤 오브 리브라");
        this.setCooldown(180.0);
        this.setDuration(40L);
        this.setDelay(540L);
        this.setRelatedSkill(new AngelOfLibraRevenge());
    }
}
