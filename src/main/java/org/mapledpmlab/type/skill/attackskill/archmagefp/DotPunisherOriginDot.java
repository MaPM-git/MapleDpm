package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DotPunisherOriginDot extends AttackSkill {
    public DotPunisherOriginDot() {
        this.setName("도트 퍼니셔(6차 이후 도트)");
        this.setDamage(290.0);
        this.setAttackCount(1L);
        this.setDotDuration(16000L);    // 익스트림 매직
        this.setInterval(1000L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new DotPunisherOriginAfterSecond());
        this.setApplyFinalAttack(true);
    }
}
