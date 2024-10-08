package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class PoisonNovaDot extends DotAttackSkill {
    public PoisonNovaDot() {
        this.setName("포이즌 노바(도트)");
        this.setDamage(660.0);
        this.setAttackCount(1L);
        this.setCooldown(25.0);
        this.setDotDuration(20000L);    // 익스트림 매직
        this.setInterval(1000L);
        //this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new PoisonNova());
        //this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
