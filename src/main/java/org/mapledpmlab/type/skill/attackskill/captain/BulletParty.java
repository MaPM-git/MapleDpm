package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BulletParty extends AttackSkill {
    public BulletParty() {
        this.setName("불릿 파티");
        this.setDamage(1675.0);
        this.setAttackCount(7L);
        this.setDelay(2400L);
        this.setDotDuration(2400L);
        this.setInterval(120L);
        this.setLimitAttackCount(20L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new BulletPartyAfterDelay());
    }
}
