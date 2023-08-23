package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BulletParty extends AttackSkill {
    public BulletParty() {
        this.setName("불릿 파티");
        this.setDamage(660.0);
        this.setAttackCount(7L);
        this.setCooldown(75.0);
        this.setDotDuration(6000L);
        this.setInterval(120L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new BulletPartyDelay());
    }
}
