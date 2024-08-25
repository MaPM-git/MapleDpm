package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MonkeyCannonBasic extends AttackSkill {
    public MonkeyCannonBasic() {
        this.setName("스페셜 몽키 에스코트(기본의 로이-몽키 캐논)");
        this.setDamage(660.0);
        this.setAttackCount(4L);
        /*this.setDotDuration(35000L);
        this.setInterval(1000L);*/
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new MonkeyCannonBomb());
        this.getMultiAttackInfo().add(2400L + 1500);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(2490L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(2490L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(2490L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(2490L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(990L);
        /*this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(3490L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(3490L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(3490L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(3490L);
        this.getMultiAttackInfo().add(1000L);*/
    }
}
