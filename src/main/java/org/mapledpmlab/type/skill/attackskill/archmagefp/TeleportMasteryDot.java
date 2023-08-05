package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TeleportMasteryDot extends AttackSkill {
    public TeleportMasteryDot() {
        this.setName("텔레포트 마스터리(도트)");
        this.setDamage(98.0);
        this.setAttackCount(1L);
        this.setInterval(2000L);
        this.setDotDuration(4000L * 2); // 익스트림 매직
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new TeleportMastery());
        this.setApplyFinalAttack(true);
    }
}
