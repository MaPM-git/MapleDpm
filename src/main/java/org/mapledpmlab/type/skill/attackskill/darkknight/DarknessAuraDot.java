package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.darkknight.DarknessAura;

public class DarknessAuraDot extends AttackSkill {
    public DarknessAuraDot() {
        this.setName("다크니스 오라(지속)");
        this.setDamage(590.0);
        this.setAttackCount(5L);
        this.setCooldown(120.0);
        this.setDotDuration(40000L);
        this.setInterval(1500L);
        this.addFinalDamage(1.6);   // 코어 강화
        this.setRelatedSkill(new DarknessAura());
    }
}
