package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BulletParty extends AttackSkill {
    public BulletParty() {
        this.setName("불릿 파티");
        this.setDamage(1435.0);
        this.setAttackCount(7L);
        this.setDelay(3720L);
        this.setDotDuration(3720L);
        this.setInterval(120L);
        this.setLimitAttackCount(31L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyFinalAttack(true);
        this.setApplyServerLag(true);
        this.setRelatedSkill(new BulletPartyAfterDelay());
    }
}
