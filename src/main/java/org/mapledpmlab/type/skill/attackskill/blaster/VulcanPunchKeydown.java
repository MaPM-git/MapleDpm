package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VulcanPunchKeydown extends AttackSkill {
    public VulcanPunchKeydown() {
        this.setName("발칸 펀치(키다운)");
        this.setAttackCount(8L);
        this.setDamage(935.0);
        this.setDelay(2160L);
        this.setDotDuration(2160L);
        this.setInterval(90L);
        this.setLimitAttackCount(24L);
        this.setRelatedSkill(new VulcanPunchAfterDelay());
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
