package org.mapledpmlab.type.skill.buffskill.bishop;

import org.mapledpmlab.type.skill.attackskill.bishop.AngelOfLibraRevenge2;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

public class AngelOfLibra2 extends BuffSkill {
    public AngelOfLibra2() {
        this.setName("엔젤 오브 리브라");
        this.setCooldown(120.0);
        this.setDuration(32L);
        this.setDelay(540L);
        this.setRelatedSkill(new AngelOfLibraRevenge2());
    }
}
