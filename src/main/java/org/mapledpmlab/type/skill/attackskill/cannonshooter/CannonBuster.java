package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CannonBuster extends AttackSkill {
    public CannonBuster() {
        this.setName("캐논 버스터");
        this.setDamage(1240.0);
        this.setAttackCount(15L);       // 캐논 버스터-보너스 어택, 벅샷
        this.setDelayByAttackSpeed(810L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(20L);         // 캐논 버스터-리인포스
        this.addFinalDamage(0.45);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
