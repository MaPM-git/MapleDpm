package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DexUnion2;

import java.util.stream.Collectors;

public class AngelicBuster5Continuous extends Job {

    public AngelicBuster5Continuous() {
        // 기본
        super();
        this.setName("엔젤릭버스터(5초, 컨티)");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2099370.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (255 + 157 + 72 + 223));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (255 + 157 + 72 + 223));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addOtherStat1(10L);
        passive.addOtherStat2(10L);
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("소울슈터 마스터리");
        passive.addAtt(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("이너 파이어");
        passive.addMainStat(40L);
        passive.addFinalDamage(1.05);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어피니티 II");
        passive.addDamage(10L);
        passive.addCriticalP(25.0);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("샤이닝 로터스");
        passive.addMainStat(20L);
        passive.addFinalDamage(1.14);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("콜 오브 에인션트");
        passive.addIgnoreDefenseList(16L);
        passive.addCriticalDamage(6.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어피니티 III");
        passive.addMainStat(40L);
        passive.addDamage(10L);
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어텐션");
        passive.addCriticalP(10.0);
        passive.addCriticalDamage(15.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("소울 게이즈");
        passive.addCriticalDamage(21.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("소울슈터 엑스퍼트");
        passive.addAtt(31L);
        passive.addFinalDamage(1.23);
        getPassiveList().add(passive);

        // 하이퍼
        passive = new Common();
        passive.setDescription("피니투라 페투치아-리듀스 아머");
        passive.addIgnoreDefenseList(15L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("트리니티 퓨전");
        passive.addMainStat(40L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("로디드 다이스");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-36L);
        this.addMainStat(-1L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new DexUnion2());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("어피니티 IV");
        doping.addDamage(25L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("소울슈터 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
